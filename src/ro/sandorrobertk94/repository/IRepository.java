package ro.sandorrobertk94.repository;

import ro.sandorrobertk94.domain.ProgramState;
import ro.sandorrobertk94.exceptions.repository.*;

/**
 * Created by robert on 12/7/15.
 */
public interface IRepository {
    void add(ProgramState state) throws RepositoryException;
    void setCurrentProgramIndex(Integer index) throws InvalidProgramIndexException;
    ProgramState getCurrentProgram() throws RepositoryException;

    void serialize(String filePath, ProgramState state) throws SerializationException;
    ProgramState deserialize(String filePath) throws DeserializationException;
    void saveCurrentStateToFile(String filePath) throws SavingToFileException;
}
