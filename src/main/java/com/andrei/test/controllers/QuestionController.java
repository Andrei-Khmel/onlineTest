package com.andrei.test.controllers;

import com.andrei.test.backup.PrintOutCheck;
import com.andrei.test.models.idCodeList;
import com.andrei.test.models.PsychotypesCalqulator;
import com.andrei.test.models.Questions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {

    Questions questionObj;
    String id = null;

    @GetMapping("/")
    public String home(Model model) {                      // ++++++++++++ 1
        model.addAttribute("title", "Главная страница");
        System.out.println("home GET");
        return "home";
    }

    @GetMapping("/identification")                   // ++++++++++++ 2
    public String showIdForm(Model model) {
        questionObj = new Questions();
        model.addAttribute("questionObj", questionObj);
        model.addAttribute("title", "identification2");
        PrintOutCheck.printInfoToConsole(questionObj, "identification GET");
        return "identification";
    }

    @PostMapping("/identification")
    public String submitIdForm(@ModelAttribute("questionObj") Questions questionObj) {
        System.out.println("identification POST");
        return "identification";
    }

    @RequestMapping(value = "/processIdentification", method = RequestMethod.POST)     // ++++++++++ 3
    public String processIdForm(@ModelAttribute("questionObj") Questions questionObj) {

        if (idCodeList.formList().contains(questionObj.getIdCode())) {
            id = questionObj.getIdCode();

            PrintOutCheck.printInfoToConsole(questionObj, "/processIdentification @RequestMapping");

            return "question";   //welcomeStudentQuestionPage ?
        } else {
            return "welcomeGuestPage";  //to be developed
        }
    }

    @GetMapping("/question")
    public String showQuestionForm(Model model) {

        if (questionObj.getIdCode() == null)
            return "identification";

        model.addAttribute("questionObj", questionObj);
        model.addAttribute("title", "question");
        return "question";
    }

    @GetMapping("/questionYesProcessing")           // ++++++++++++++   4
    public String showQuestionYesForm(Model model) {

        if (id == null) {
            return "identification";
        } else if (questionObj.getIdCode() == null) {
            questionObj.setIdCode(id);
        }
        model.addAttribute("questionObj", questionObj);
        model.addAttribute("title", "question");

        questionObj.results[questionObj.getCurrentQuestionNumber()] = "Yes";

        PrintOutCheck.printInfoToConsole(questionObj, "/questionYesProcessing GET");

        if (questionObj.getCurrentQuestionNumber() < questionObj.getQuestions().length - 1) {
            questionObj.setCurrentQuestionNumber(questionObj.getCurrentQuestionNumber() + 1);
            return "question";
        } else {
            System.out.println(PsychotypesCalqulator.calqulatePsychotypes(questionObj.results));
//            saveResultsToFile(){};
            return "goodbyeForm";
        }
    }

    @GetMapping("/questionNoProcessing")
    public String showQuestionNoForm(Model model) {

        if (id == null) {
            return "identification";
        } else if (questionObj.getIdCode() == null) {
            questionObj.setIdCode(id);
        }

        model.addAttribute("questionObj", questionObj);
        model.addAttribute("title", "question");

        questionObj.results[questionObj.getCurrentQuestionNumber()] = "No";

        PrintOutCheck.printInfoToConsole(questionObj, "/questionNoProcessing GET");

        if (questionObj.getCurrentQuestionNumber() < questionObj.getQuestions().length - 1) {
            questionObj.setCurrentQuestionNumber(questionObj.getCurrentQuestionNumber() + 1);
            return "question";
        } else {
            System.out.println(PsychotypesCalqulator.calqulatePsychotypes(questionObj.results));
//            saveResultsToFile(){};
            return "goodbyeForm";
        }
    }

    @GetMapping("/goodbyeForm")
    public String showGoodbyeForm(Model model) {
        model.addAttribute("title", "question");

        System.out.println("goodbyeForm GET");
        return "goodbyeForm";
    }
}
