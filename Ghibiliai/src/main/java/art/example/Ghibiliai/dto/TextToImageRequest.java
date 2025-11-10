package art.example.Ghibiliai.dto;

import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
public class TextToImageRequest {

    private List<TextPrompt>  text_prompts;
    private double cfg_scale=7;
    private int height=512;
    private int sample =1;
    private int steps=20;
    private String style_preset;

   public static class TextPrompt {
       private String text;

       public TextPrompt(String text) {
           this.text = text;
       }

       public String getText() {
           return text;
       }

       public void setText(String text) {
           this.text = text;
       }

   }

   public TextToImageRequest(String text, String style){
       this.text_prompts = List.of(new TextPrompt(text));
       this.style_preset = style;
   }


   }

