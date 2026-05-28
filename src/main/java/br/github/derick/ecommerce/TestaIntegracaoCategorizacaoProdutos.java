package br.github.derick.ecommerce;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.Arrays;

public class TestaIntegracaoCategorizacaoProdutos {
     public static void main(String[] args){
              var user = "folha de papel";
              var system = """ 
                      voce e um categoriazador de produtos e deve trazer somente o nome da gategoroia do produto informado
                       
                       escolha uma categoria dentra a lista abaixo:
                       1. higiene pessoal
                       2. eletronica
                       3. carros
                       4. pereciveis
                       5. outros
                      
             ### exemplo de uso:
             resposta:esporte
                       
                       """;
                      var chave = System.getenv("openai");
            var service = new OpenAiService(chave, Duration.ofSeconds(30));
         var completionRequest  = ChatCompletionRequest
                 .builder()
                 .model("gpt-5.4-mini")
                 .messages(Arrays.asList(
                         new ChatMessage(ChatMessageRole.USER.value(), user),
                         new ChatMessage(ChatMessageRole.SYSTEM.value(),system)
                 ))
                 .n(5)
                 .build();
         service
                 .createChatCompletion(completionRequest)
                 .getChoices()
                 .forEach(c -> {
                     System.out.println(c.getMessage().getContent());
                System.out.println("\n-----------------------------\n");
                 });
     }
}
