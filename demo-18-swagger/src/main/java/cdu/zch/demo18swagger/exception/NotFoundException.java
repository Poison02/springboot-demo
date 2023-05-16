package cdu.zch.demo18swagger.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Zch
 * @data 2023/5/16
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -3420141561658396746L;
    private String message;
}
