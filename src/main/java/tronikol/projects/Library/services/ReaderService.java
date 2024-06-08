package tronikol.projects.Library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tronikol.projects.Library.models.Reader;
import tronikol.projects.Library.repositories.ReaderRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReaderService {
    private final ReaderRepo readerRepo;
    @Autowired
    public ReaderService(ReaderRepo readerRepo) {
        this.readerRepo = readerRepo;
    }

    public List<Reader> findAll() {
        return readerRepo.findAll();
    }
}
