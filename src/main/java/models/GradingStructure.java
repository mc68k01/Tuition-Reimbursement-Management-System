package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "grading_formats")
public class GradingStructure {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grading_format_id")
    private int gradingFormatId;
    // int primary key references tuition_reimbursement_forms(grading_format_id),
    @Column ( name = "grading_format")
    private String gradingFormat;
    @Column(name = "grading_presentation")
    private boolean gradingPresentation;
    @Column (name = "grading_cutoff")
    private BigDecimal gradingCutoff;
    // numeric(3,1) /* set default passing grade if one is not given */

    public GradingStructure() {
    }

    public GradingStructure(int gradingFormatId, String gradingFormat, boolean gradingPresentation, BigDecimal gradingCutoff) {
        this.gradingFormatId = gradingFormatId;
        this.gradingFormat = gradingFormat;
        this.gradingPresentation = gradingPresentation;
        this.gradingCutoff = gradingCutoff;
    }

    public int getGradingFormatId() {
        return gradingFormatId;
    }

    public void setGradingFormatId(int gradingFormatId) {
        this.gradingFormatId = gradingFormatId;
    }

    public String getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(String gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public boolean isGradingPresentation() {
        return gradingPresentation;
    }

    public void setGradingPresentation(boolean gradingPresentation) {
        this.gradingPresentation = gradingPresentation;
    }

    public BigDecimal getGradingCutoff() {
        return gradingCutoff;
    }

    public void setGradingCutoff(BigDecimal gradingCutoff) {
        this.gradingCutoff = gradingCutoff;
    }

    @Override
    public String toString() {
        return "GradingStructure{" +
                "gradingFormatId=" + gradingFormatId +
                ", gradingFormat='" + gradingFormat + '\'' +
                ", gradingPresentation=" + gradingPresentation +
                ", gradingCutoff=" + gradingCutoff +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradingStructure that = (GradingStructure) o;
        return gradingFormatId == that.gradingFormatId && gradingPresentation == that.gradingPresentation && Objects.equals(gradingFormat, that.gradingFormat) && Objects.equals(gradingCutoff, that.gradingCutoff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradingFormatId, gradingFormat, gradingPresentation, gradingCutoff);
    }
}
