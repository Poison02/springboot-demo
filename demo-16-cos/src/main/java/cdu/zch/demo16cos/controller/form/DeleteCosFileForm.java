package cdu.zch.demo16cos.controller.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author Zch
 * @data 2023/4/26
 **/
@Data
public class DeleteCosFileForm {
    @NotEmpty(message = "path不能为空")
    private String[] path;
}
