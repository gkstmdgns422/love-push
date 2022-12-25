package com.cupid.joalarm.feed.childcomment;

import com.cupid.joalarm.account.entity.Account;
import com.cupid.joalarm.baseEntity.BaseTimeEntity;
import com.cupid.joalarm.feed.comment.Comment;
import com.cupid.joalarm.feed.like.Like;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "childcomment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ChildComment extends BaseTimeEntity {

    @Id
    @Column(name = "child_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childId;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder.Default
    @OneToMany(mappedBy = "childComment",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"childComment"})
    private List<Like> likes = new ArrayList<>();

    @Column(name = "like_cnt")
    private Long likeCnt;
}
