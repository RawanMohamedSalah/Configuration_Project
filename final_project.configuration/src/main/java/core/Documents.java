package core;

public class Documents {
	private int documents_id;
    private String documents_name;
    private String documents_description;
    private String documents_image;

    public int getDocuments_id() {
        return documents_id;
    }

    public void setDocuments_id(int documents_id) {
        this.documents_id = documents_id;
    }

    public String getDocuments_name() {
        return documents_name;
    }

    public void setDocuments_name(String documents_name) {
        this.documents_name = documents_name;
    }

    public String getDocuments_description() {
        return documents_description;
    }

    public void setDocuments_description(String documents_description) {
        this.documents_description = documents_description;
    }

    public String getDocuments_image() {
        return documents_image;
    }

    public void setDocuments_image(String documents_image) {
        this.documents_image = documents_image;
    }
}