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

@Entity
@Table(name = "designer_board_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesignerBoardImageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designerBoardImageNumber;
    private String designerBoardImageUrl;
    private Integer designerBoardNumber;

    public DesignerBoardImageEntity(Integer designerBoardNumber, String designerBoardImageUrl) {
        this.designerBoardNumber = designerBoardNumber;
        this.designerBoardImageUrl = designerBoardImageUrl;
    }
}
