package jdbc.entity;

public class Film {
    private int id;
    private String fName;
    private Double fPrice;
    private String imgSrc;
    private String comments;
    private String type;

    @Override
    public String toString() {
        return "film{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", fPrice=" + fPrice +
                ", imgSrc='" + imgSrc + '\'' +
                ", comments='" + comments + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Double getfPrice() {
        return fPrice;
    }

    public void setfPrice(Double fPrice) {
        this.fPrice = fPrice;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Film(int id, String fName, Double fPrice, String imgSrc, String comments, String type) {
        this.id = id;
        this.fName = fName;
        this.fPrice = fPrice;
        this.imgSrc = imgSrc;
        this.comments = comments;
        this.type = type;
    }

    public Film() {
    }
}
