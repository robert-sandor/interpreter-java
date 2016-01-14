package ro.sandorrobertk94.controller;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.controller.ControllerException;
import ro.sandorrobertk94.exceptions.repository.DeserializationException;
import ro.sandorrobertk94.exceptions.repository.SavingToFileException;
import ro.sandorrobertk94.exceptions.repository.SerializationException;
import ro.sandorrobertk94.repository.IRepository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by robert on 12/7/15.
 */
public class Controller {
    private IRepository repository;
    private String logFilePath;
    private boolean writeToFile;

    public Controller(IRepository repository) {
        this.repository = repository;
        logFilePath = null;
        writeToFile = false;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public boolean isWriteToFile() {
        return writeToFile;
    }

    public void setWriteToFile(boolean writeToFile) {
        this.writeToFile = writeToFile;
    }

    public IRepository getRepository() {
        return repository;
    }

    public List<ProgramState> removeCompletedPrograms(List<ProgramState> list) {
        return list.stream().filter(ProgramState::isNotCompleted).collect(Collectors.toList());
    }

    public void oneStepForAllPrograms(List<ProgramState> list) throws InterruptedException {
        list.forEach(prg -> {
            if (writeToFile) {
                try {
                    repository.saveStateToFile(prg, logFilePath);
                } catch (SavingToFileException ignored) {
                    // TODO handle this exception if it causes problems
                }
            } else {
                System.out.println(prg.toString());
            }
        });

        List<Callable<ProgramState>> callList = list.stream()
                .map(p -> (Callable<ProgramState>) p::oneStep)
                .collect(Collectors.toList());

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<ProgramState> newList =
                executor.invokeAll(callList).stream()
                        .map(future -> {
                            try {
                                return future.get();
                            } catch (Exception e) {
                                return null;
                            }
                        }).filter(p -> p != null)
                        .collect(Collectors.toList());

        list.forEach(p -> {
            if (!newList.stream().anyMatch(s -> Objects.equals(s.getId(), p.getId())))
                newList.add(p);
        });

        if (!writeToFile) {
            newList.forEach(p -> {
                try {
                    repository.saveStateToFile(p, logFilePath);
                } catch (SavingToFileException ignored) {
                }
            });
        }

        repository.setPrograms(newList);
        executor.shutdown();
    }

    public void allStep() throws ControllerException, InterruptedException {
        while (true) {
            List<ProgramState> list = removeCompletedPrograms(repository.getPrograms());
            if (list.size() == 0) {
                return;
            } else {
                oneStepForAllPrograms(list);
            }
        }
    }

    public void serializePrograms() throws SerializationException {
        repository.serialize("serialized.bin");
    }

    public void deserializePrograms() throws DeserializationException {
        repository.setPrograms(repository.deserialize("serialized.bin"));
    }
}
