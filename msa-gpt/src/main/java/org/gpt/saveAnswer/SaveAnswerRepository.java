package org.gpt.saveAnswer;

import org.gpt.Gptanswervo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveAnswerRepository extends JpaRepository<Gptanswervo, Integer> {

}
