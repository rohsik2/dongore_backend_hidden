package com.sns.dongore.photo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data @AllArgsConstructor
public class PostPhotosReq {
    MultipartFile[] photos;
}
