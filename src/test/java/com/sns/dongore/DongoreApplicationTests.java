package com.sns.dongore;

import com.sns.dongore.photo.entity.Photo;
import com.sns.dongore.post.entity.Post;
import com.sns.dongore.post.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class DongoreApplicationTests {

	@Autowired
	private EntityManager em;

	@Autowired
	private PostRepo postRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void 포스트저장확인() throws Exception{
	}
}
