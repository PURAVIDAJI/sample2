package com.example.sample2.service;

import com.example.sample2.domain.Score;
import com.example.sample2.domain.Student;
import com.example.sample2.repository.ScoreRepository;
import com.example.sample2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(int id){
        return studentRepository.findById(id);

    }

    //스코어변경시 -> 외부에서 주입받은 스코어를 사용하여 평균 내어 다시
    public String updateStudent(int id,Score score){


        Student foundStu = studentRepository.findById(id);
        float newScore = (foundStu.getPoint()+score.getPoint())/2.0f;
        foundStu.setPoint(newScore);
        studentRepository.updateStudent(foundStu);

        return "수정완료";

    }

    public Student insertStudent(Student student){
        String res="";
        Integer i = studentRepository.insertStudent(student);
        //인서트 된 항목의 id값이 담김..!
        Student updated = findById(i);
        if(i !=null){
            res="추가 완료";
        }
        System.out.println(res);
        return updated;
        //student를 넣어도 되긴됨. 레포지토리에서
    }


}
