package ro.sandorrobertk94.repository;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.repository.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 12/7/15.
 */
public class Repository implements IRepository {
    private List<ProgramState> programs;
    private Integer currentProgramIndex;

    public Repository() {
        programs = new ArrayList<>();
    }

    public Repository(ProgramState state) {
        programs = new ArrayList<>();
        programs.add(state);
        currentProgramIndex = 0;
    }

    @Override
    public void add(ProgramState state) throws RepositoryException {
        programs.add(state);
    }

    @Override
    public Integer getCurrentProgramIndex() {
        return currentProgramIndex;
    }

    @Override
    public void setCurrentProgramIndex(Integer index) throws InvalidProgramIndexException {
        if (index < 0 || index >= programs.size()) {
            throw new InvalidProgramIndexException();
        }

        currentProgramIndex = index;
    }

    @Override
    public List<ProgramState> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramState> programs) {
        this.programs = programs;
    }

    @Override
    public ProgramState getCurrentProgram() throws RepositoryException {
        return programs.get(currentProgramIndex);
    }

    @Override
    public void serialize(String filePath) throws SerializationException {
        try (
                OutputStream file = new FileOutputStream(filePath);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer)
        ) {
            output.writeObject(programs);
        } catch (IOException e) {
            throw new SerializationException();
        }
    }

    @Override
    public ArrayList<ProgramState> deserialize(String filePath) throws DeserializationException {
        try (
                InputStream file = new FileInputStream(filePath);
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer)
        ) {
            return (ArrayList<ProgramState>) input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new DeserializationException();
        }
    }

    @Override
    public void saveStateToFile(ProgramState state, String filePath) throws SavingToFileException {
        try (
                PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))
        ) {
            output.println(state.toString());
        } catch (IOException ex) {
            throw new SavingToFileException();
        }
    }
}
