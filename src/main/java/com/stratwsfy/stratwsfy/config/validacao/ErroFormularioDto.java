package com.stratwsfy.stratwsfy.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ErroFormularioDto {

    private String campo;
    private String erro;


}
