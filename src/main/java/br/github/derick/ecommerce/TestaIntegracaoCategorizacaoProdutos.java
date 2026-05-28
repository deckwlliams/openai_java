package br.github.derick.ecommerce;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class TestaIntegracaoCategorizacaoProdutos {
     public static void main(String[] args) {
         var tcd = new Scanner(System.in);


             System.out.println("digite as categorias validas:");
             var categoria = tcd.nextLine();
         while (true) {
             System.out.println("\n digite o nome do produto: ");
             var user = tcd.nextLine();


             var system = """ 
                              voce e um categoriazador de produtos e deve trazer somente o nome da gategoroia do produto informado
                     
                               escolha uma categoria dentra a lista abaixo:
                           %s
                     ### exemplo de uso:
                     resposta:esporte
                     
                     ### regras a serem seguidas:
                     caso o usuario pergunte algo que não seja de categorização de produtos, voce deve responder que nao deve ajuda rpois seu papel e apenas responder a categoria dos produtos
                     """.formatted(categoria);
             dispararRequisicao(user, system);

         }
     }
     public static void dispararRequisicao(String user, String system){
         var chave = System.getenv("openai");
         var service = new OpenAiService(chave, Duration.ofSeconds(30));
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
