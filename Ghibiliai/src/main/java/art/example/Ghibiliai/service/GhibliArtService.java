package art.example.Ghibiliai.service;

import art.example.Ghibiliai.client.StabilityAIClient;
import art.example.Ghibiliai.dto.TextToImageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GhibliArtService {

    private final StabilityAIClient stabilityAIClient;
    private final String apiKey;

    public GhibliArtService(StabilityAIClient stabilityAIClient, @Value("${stability.api.key}") String apiKey){
        this.stabilityAIClient=stabilityAIClient;
        this.apiKey=apiKey;
    }

    public byte[] createGhibliArt(MultipartFile image,String prompt) {
        String finalPrompt = prompt + ", in the beautiful , detailed anime style of studio ghibili.";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = "anime";

        return stabilityAIClient.generateImageFromImage(
                "Bearer " + apiKey,
                engineId,
                image,
                finalPrompt,
                stylePreset
        );
    }

    public byte[] createGhibliArtFromText(String prompt, String style) {
        String finalPrompt = prompt + ", in the beautiful , detailed anime style of studio ghibili.";
        String engineId = "stable-diffusion-v1-6";

        String stylePreset = style.equals("general") ? "anime": style.replace("_","_");

        TextToImageRequest requestPayload = new TextToImageRequest(finalPrompt,stylePreset);
        return stabilityAIClient.generateImageFromText(
                "Bearer " + apiKey,
                engineId,
                requestPayload
        );
    }

    // 🧠 Text-to-Image
   /* public byte[] createGhibliArtFromText(String prompt) {
        String finalPrompt = prompt + ", in the beautiful, detailed anime style of Studio Ghibli.";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = "anime";

        TextToImageRequest requestPayload = new TextToImageRequest(finalPrompt, stylePreset);

        return stabilityAIClient.generateImageFromText(
                "Bearer " + apiKey,
                engineId,
                requestPayload
        );
    }*/

}



