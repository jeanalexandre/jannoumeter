package com.jannouMetter.service;

import com.jannouMetter.bo.Answer;
import com.jannouMetter.bo.Ask;
import com.jannouMetter.dao.AnswerRepository;
import com.jannouMetter.dao.AskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AskService {

    private AskRepository askRepository;
    private AnswerRepository answerRepository;

    public AskService(AskRepository askRepository, AnswerRepository answerRepository) {
        this.answerRepository =answerRepository;
        this.askRepository = askRepository;
    }

    public List<Ask> getAll() {
        return this.askRepository.findAll();
    }

    public Optional<Ask> getById(Long id) {
        return this.askRepository.findById(id);
    }

    public Ask addAnswer(Ask ask, Answer answer) {
        answer.setAsk(ask);
        answerRepository.save(answer);
        return ask;
    }
}