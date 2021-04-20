package min.micro.api.article;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;


@Component
public class ArticleDto {

    private long articleId;

    private String writer;
    private String email;
    private String subject;
    private String content;
    private String rdate;

   public void setWriter(String writer){
       this.writer=writer;
   }

   public String getWriter() {
        return this.writer;
   }


   public void setContent(String Content){
       this.content=content;
   }

   public String getContent(){
       return this.content;
   }

    public String toString(){
        return "writer : " + this.writer;
    }

}
