package br.com.aweb.to_do_list.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(length = 100, nullable = false)  // Define que a coluna 'title' terá no máximo 100 caracteres e não pode ser nula
    private String title;  // Título da tarefa

    @Column(nullable = false)  // Define que a coluna 'createdAt' não pode ser nula
    private LocalDateTime createdAt;  // Data e hora de criação da tarefa

    @Column(nullable = false)  // Define que a coluna 'deadline' não pode ser nula
    private LocalDate deadline;  // Data limite para a conclusão da tarefa

    @Column(nullable = true)  // Define que a coluna 'finishedAt' pode ser nula
    private LocalDate finishedAt;  // Data em que a tarefa foi concluída (se aplicável)
}