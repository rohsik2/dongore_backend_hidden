package com.sns.dongore.photo.model;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Data @AllArgsConstructor
public class PostPhotosReq {
    String text;
    @ApiParam(value="File", required=true)
    ArrayList<MultipartFile> photos;
}
