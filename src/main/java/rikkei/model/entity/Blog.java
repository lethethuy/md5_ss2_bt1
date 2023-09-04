package rikkei.model.entity;

import javax.persistence.*;

@Entity // danh dau day la 1 Entity
@Table(name = "blogs") // tạo bảng tự động trong database nếu bảng đó chưa có tên thì lấy luôn tên class
public class Blog {
    @Id // annotation đặt đây là 1 khoá chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tang id khoa chinh theo kieu int
    private Long id;

    @Column(nullable = false, columnDefinition = "text") // ô content kiểu dữ liệu text, not null
    private String content;
    private String title;
    private boolean status;

    public Blog(Long id, String content, String title, boolean status) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.status = status;
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
