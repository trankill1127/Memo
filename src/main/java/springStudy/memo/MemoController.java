package springStudy.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository repository;
    private final MemoService service;

    @PostMapping("/api/post")
    public Memo createMemo(@RequestBody MemoDTO memoDTO){
        Memo memo = new Memo(memoDTO.getContents());
        return (Memo) repository.save(memo);
    }

    @GetMapping("/api/get")
    public List<Memo> getMemos(){
        return repository.findAll();
    }

    @PutMapping("/api/update/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoDTO memoDto){
        service.update(id, memoDto.getContents());
        return id;
    }

    @DeleteMapping("/api/delete/{id}")
    public Long deleteMemo(@PathVariable Long id){
        repository.deleteById(id);
        return id;
    }

}
