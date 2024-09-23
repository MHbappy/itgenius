package products.dto;
import lombok.*;

@Data
//Our own customization of userdetails with more fields to register
public class UserDTO{
    private String username;
    private String fullname;
    private String street;
    private String city;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private Long id;
}