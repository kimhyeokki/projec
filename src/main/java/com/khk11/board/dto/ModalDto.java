package com.khk11.board.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ModalDto {
    private String isState;
    private String title;
    private String msg;
}
