package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;


public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController controller;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void naoSalvarTarefaSemDescricao() {
        Task task = new Task();
        task.setDueDate(LocalDate.now());
        try {
            controller.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }


    @Test
    public void naoSalvarTarefaSemData() {
        Task task = new Task();
        try {
            controller.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void naoSalvarTarefaComDataPassada() {
        Task task = new Task();
        task.setDueDate(LocalDate.of(200, 01, 01));
        try {
            controller.save(task);
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void deveSalvarTarefaComSucesso() throws ValidationException {
        Task task = new Task();
        task.setTask("Descrição");
        task.setDueDate(LocalDate.now());
        task.setDueDate(LocalDate.now());
        controller.save(task);
    }
}