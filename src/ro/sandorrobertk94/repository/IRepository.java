package ro.sandorrobertk94.repository;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.repository.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert on 12/7/15.
 */
public interface IRepository {
    void add(ProgramState state) throws RepositoryException;

    Integer getCurrentProgramIndex();

    void setCurrentProgramIndex(Integer index) throws InvalidProgramIndexException;

    ProgramState getCurrentProgram() throws RepositoryException;

    List<ProgramState> getPrograms();

    void setPrograms(List<ProgramState> programs);

    void serialize(String filePath) throws SerializationException;

    ArrayList<ProgramState> deserialize(String filePath) throws DeserializationException;

    void saveStateToFile(ProgramState state, String filePath) throws SavingToFileException;
}
