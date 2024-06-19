package com.back.back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.back.back.entity.LikeEntity;
import com.back.back.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeListItem {
	private String userId;

	public LikeListItem(LikeEntity likeEntity) {
		this.userId = likeEntity.getUserId();
	}

	public static List<LikeListItem>  getLikeList(List<LikeEntity> likeEntities) {
		List<LikeListItem> list = new ArrayList<>();
		for (LikeEntity likeEntity : likeEntities) {
			LikeListItem likeListItem = new LikeListItem(likeEntity);
			list.add(likeListItem);
		}
		return list;
	}
}
