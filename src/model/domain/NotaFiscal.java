package src.model.domain;

import java.util.Date;

public class NotaFiscal {
    Date data;

    public NotaFiscal() {
        this.data = new Date();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
