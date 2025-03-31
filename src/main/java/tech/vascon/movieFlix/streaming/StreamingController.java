package tech.vascon.movieFlix.streaming;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService service;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll() {
        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = service.save(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(category -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
