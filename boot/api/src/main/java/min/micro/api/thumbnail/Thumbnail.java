package min.micro.api.thumbnail;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Thumbnail {
    public static void main(String[] args) {
        try{
            int thumbnail_width =100;
            int thumbnail_height=100;

            File origin_file_name = new File("C:\\Users\\w\\Desktop\\photo"+File.separator+"image.png");
            File thumbnail_file_name = new File("C:\\Users\\w\\Desktop\\photo"+File.separator+"thumbnail.png");

            BufferedImage buffer_origin_image = ImageIO.read(origin_file_name);
            BufferedImage buffer_thumb_image = new BufferedImage(thumbnail_width, thumbnail_height, BufferedImage.TYPE_3BYTE_BGR);

            Graphics2D graphic = buffer_thumb_image.createGraphics();
            graphic.drawImage(buffer_origin_image, 0, 0, thumbnail_width, thumbnail_height, null);
            ImageIO.write(buffer_thumb_image, "jpg", thumbnail_file_name);
            System.out.println("썸네일 생성 완료");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
