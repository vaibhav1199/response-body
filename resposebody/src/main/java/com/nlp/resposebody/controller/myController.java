package com.nlp.resposebody.controller;

import java.util.ArrayList;
import java.util.List;

import com.nlp.resposebody.model.body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@RestController
public class myController {
    @Autowired
    private StanfordCoreNLP stanfordcorenlp;

    @GetMapping(value="/body")
    public @ResponseBody body getbody(@RequestBody final String input){
        body user = new body();
        List<String> target = new ArrayList();
        List<String> action = new ArrayList();
        CoreDocument coreDocument = new CoreDocument(input);
        stanfordcorenlp.annotate(coreDocument);
        List<CoreLabel> coreLabels = coreDocument.tokens();
        // show my appointment or show vaibhav's appointment or show my data

        for(CoreLabel coreLabel : coreLabels) {
            //printing the all the tokens
            String value = coreLabel.originalText();
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            String lemma = coreLabel.lemma();
            if(pos.equals("NNP")){
                target.add(value);
            }
            else if((pos.equals("NN") || pos.equals("NNS")) && !(lemma.equals("show"))){
                action.add(lemma);
            }
        }
        user.setTarget(target);
        user.setAction(action);
        return user;
    }
}