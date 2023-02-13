package com.uax.accesodatos.AppFutbolApi.dto.equipos;

import java.util.List;

public class EquiposResponseDTO {
    private List<EquiposDTO> data;

    public List<EquiposDTO> getData() {
        return data;
    }

    public void setData(List<EquiposDTO> data) {
        this.data = data;
    }
}
