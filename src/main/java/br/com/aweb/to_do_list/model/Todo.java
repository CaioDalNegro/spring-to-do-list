package br.com.aweb.to_do_list.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // Define que a classe será mapeada para uma tabela no banco de dados
@NoArgsConstructor  // Gera um construtor sem argumentos
@AllArgsConstructor  // Gera um construtor com todos os argumentos
@Data  // Gera getters, setters e outros métodos úteis automaticamente
public class Todo {

    // Atributos da classe--------------------->

    @Id  // Indica que o campo 'id' será a chave primária na tabela do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Garante que o valor do 'id' será gerado automaticamente pelo banco de dados
    private Long id;  // Identificador único para a tarefa

    @Size(min = 3, max=100)
    @NotBlank
    @Column(length = 100, nullable = false)  // Define que a coluna 'title' terá no máximo 100 caracteres e não pode ser nula
    private String title;  // Título da tarefa

    @Column(nullable = false)  // Define que a coluna 'createdAt' não pode ser nula
    private LocalDateTime createdAt = LocalDateTime.now();  // Data e hora de criação da tarefa

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(iso = ISO.DATE)
    @Column(nullable = false)  // Define que a coluna 'deadline' não pode ser nula
    private LocalDate deadline;  // Data limite para a conclusão da tarefa

    @Column(nullable = true)  // Define que a coluna 'finishedAt' pode ser nula
    private LocalDate finishedAt;  // Data em que a tarefa foi concluída (se aplicável)
}