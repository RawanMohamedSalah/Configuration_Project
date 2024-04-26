package core;

import java.util.List;

public interface DocumentsDao {
    List<Documents> getAllDocuments();

    Documents getDocument(int documentId);

    void saveDocument(Documents document);

    void updateDocument(Documents document);

    void deleteDocument(int documentId);
}