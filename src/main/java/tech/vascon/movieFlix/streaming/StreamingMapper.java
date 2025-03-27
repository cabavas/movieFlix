package tech.vascon.movieFlix.streaming;

import lombok.experimental.UtilityClass;


@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request) {
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming category) {
        return StreamingResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
