package com.springlearn.demo.disc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author justZero
 * @since 2018/12/30
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OtherDisc implements Disc {

    @Value("${disc1.title}")
    private String title;

    @Value("${disc1.artist}")
    private String artist;

    public void info() {
        System.out.println("title: "+title+", artist: "+artist);
    }

}
