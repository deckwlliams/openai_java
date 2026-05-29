package br.github.derick.ecommerce;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.ModelType;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;

public class IdentificadorDePerfil {

    public static void main(String[] args) {
        var promptSistema = """
                Identifique o perfil de compra de cada cliente.
                
                A resposta deve ser:
                
                Cliente - descreva o perfil do cliente em três palavras
                """;

        var clientes = carregarClientesDoArquivo();
var modelo = "gpt-5.4-mini";
var tamanho = 2048;
var qtd = contarTokens(clientes);
if(qtd > 4096 - tamanho){
    modelo = "gpt-5.5";
}
System.out.println("qtd tokens " + qtd);
        System.out.println("Modelo escolhido " + modelo);

        var request = ChatCompletionRequest
                .builder()
                .model(modelo)
                .messages(Arrays.asList(
                        new ChatMessage(
                                ChatMessageRole.SYSTEM.value(),
                                promptSistema),
                        new ChatMessage(
                                ChatMessageRole.SYSTEM.value(),
                                clientes)))
                .build();

        var chave = System.getenv("openai");
        var service = new OpenAiService(chave, Duration.ofSeconds(30));

        System.out.println(
                service
                        .createChatCompletion(request)
                        .getChoices().get(0).getMessage().getContent());
    }

    private static int contarTokens(String prompt) {
        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        Encoding enc = registry.getEncodingForModel(ModelType.GPT_3_5_TURBO );
        return enc.countTokens(prompt);

    }

    private static String carregarClientesDoArquivo() {
        try {
            var path = Path.of(ClassLoader
                    .getSystemResource("lista_de_compras_10_clientes.csv")
                    .toURI());
            return Files.readAllLines(path).toString();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar o arquivo!", e);
        }
    }

}