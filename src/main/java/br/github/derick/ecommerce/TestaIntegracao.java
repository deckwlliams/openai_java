package br.github.derick.ecommerce;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import java.util.Arrays;

public class TestaIntegracao {
     public static void main(String[] args){
              var user = "gere 10 produtos";
              var system = "voce e uma gerador de produtos ficticios para um ecommerce e deve gerar apenas o  nome dos produtos listados";
var chave = System.getenv("openai");
            var service = new OpenAiService(chave);
         var completionRequest  = ChatCompletionRequest
                 .builder()
                 .model("gpt-5.4-mini")
                 .messages(Arrays.asList(
                         new ChatMessage(ChatMessageRole.USER.value(), user),
                         new ChatMessage(ChatMessageRole.SYSTEM.value(),system)
                 ))
                 .build();
         service
                 .createChatCompletion(completionRequest)
                 .getChoices()
                 .forEach(c -> System.out.println(c.getMessage().getContent()));
     }
}
