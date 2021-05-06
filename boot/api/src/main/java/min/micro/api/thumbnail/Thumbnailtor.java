package min.micro.api.thumbnail;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Thumbnailtor {
    public static void getSimilarProductsFile(
            String projectId,
            String computeRegion,
            String productSetId,
            String productCategory,
            String filePath,
            String filter
