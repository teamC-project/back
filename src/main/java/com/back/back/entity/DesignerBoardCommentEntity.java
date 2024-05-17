package com.back.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="designerBoardComment")
@Table(name="designerBoardComment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesignerBoardCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designerBoardCommentNumber;
    private Integer designerBoardNumber;
    private String designerBoardCommentWriterId;
    private String designerBoardCommentContents;
    private String designerBoardCommentWriteDatetime;
}
