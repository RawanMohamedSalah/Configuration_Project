package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class DocumentsDaoImpl implements DocumentsDao {
    private DatabaseConnection dbConnection;

    public DocumentsDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Documents> getAllDocuments() {
        List<Documents> documents = new ArrayList<>();
        String sql = "SELECT * FROM documents";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int documentId = rs.getInt("document_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String imageUrl = rs.getString("image_url");
                documents.add(new Documents(documentId, name, description, imageUrl));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return documents;
    }

    @Override
    public Documents getDocument(int documentId) {
        Documents document = null;
        String sql = "SELECT * FROM documents WHERE document_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, documentId);
            try (ResultSet rs = preparedStatement.executeQuery()) {

                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String imageUrl = rs.getString("image_url");
                    document = new Documents(documentId, name, description, imageUrl);
                }
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return document;
    }

    @Override
    public void saveDocument(Documents document) {
        String sql = "INSERT INTO documents (name, description, image_url) VALUES (?, ?, ?)";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, document.getName());
            preparedStatement.setString(2, document.getDescription());
            preparedStatement.setString(3, document.getImageUrl());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }

    @Override
    public void updateDocument(Documents document) {
        String sql = "UPDATE documents SET name =?, description =?, image_url =? WHERE document_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, document.getName());
            preparedStatement.setString(2, document.getDescription());
            preparedStatement.setString(3, document.getImageUrl());
            preparedStatement.setInt(4, document.getDocumentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }

    @Override
    public void deleteDocument(int cityId) {
        String sql = "DELETE FROM cities WHERE city_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, documentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }
    }
