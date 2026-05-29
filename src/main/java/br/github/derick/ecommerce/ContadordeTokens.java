package br.github.derick.ecommerce;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.*;

import java.math.BigDecimal;

public class ContadordeTokens {
    public  static void main(String[] args){

        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        Encoding enc = registry.getEncodingForModel(ModelType.GPT_3_5_TURBO );
        int qtd = enc.countTokens("Identifique o perfil de compra de cada cliente ");

        System.out.println(("quantidade de tokens " + qtd));
 var custo = new BigDecimal(qtd)
         .divide(new BigDecimal("1000"))
                 .multiply(new BigDecimal("0.0010"));
         System.out.println("Custo de requisição: " + custo);

    }
}
