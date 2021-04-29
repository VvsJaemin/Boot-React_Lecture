package min.micro.api.qbs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import min.micro.api.qbs.domain.QnaBoard;
import min.micro.api.qbs.service.QnaBoardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/qna")
@CrossOrigin(origins = "*")
public class QnaBoardController {

    private final QnaBoardServiceImpl service;

    @PostMapping("")
    public ResponseEntity<QnaBoard> save(@RequestBody QnaBoard qnaboard) {
        log.info("등록완료");
        service.save(qnaboard);

        log.info("register board.getBoardNo() = " + qnaboard.getBoardNo());
        return new ResponseEntity<>(qnaboard, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<QnaBoard>> list() {

        log.info("list()");

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<QnaBoard>> read(@PathVariable long id) {
        log.info("read()");

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/modify/{boardNo}")
    public ResponseEntity<QnaBoard> modify(
            @PathVariable("boardNo")long boardNo,
            @RequestBody QnaBoard qnaboard) {

        log.info("Put - modify()");
        log.info("boardNo long: " + boardNo);
        log.info("boardNo entity: " + qnaboard.getBoardNo());
         service.save(qnaboard);
        return new ResponseEntity<>(qnaboard, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{boardNo}")

    public ResponseEntity<String> remove(@PathVariable long boardNo) {

        service.deleteById(boardNo);
        log.info("remove");

        return new ResponseEntity<>("delete success!", HttpStatus.OK);
    }

}
