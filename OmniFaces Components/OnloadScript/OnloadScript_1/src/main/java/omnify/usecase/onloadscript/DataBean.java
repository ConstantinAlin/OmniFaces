package omnify.usecase.onloadscript;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class DataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rows = "3";
    private String cols = "3";

    public DataBean() {
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getCols() {
        return cols;
    }

    public void setCols(String cols) {
        this.cols = cols;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.rows);
        hash = 89 * hash + Objects.hashCode(this.cols);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataBean other = (DataBean) obj;
        if (!Objects.equals(this.rows, other.rows)) {
            return false;
        }
        if (!Objects.equals(this.cols, other.cols)) {
            return false;
        }
        return true;
    }
}
