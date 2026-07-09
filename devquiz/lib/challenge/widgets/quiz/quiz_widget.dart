import 'package:DevQuiz/challenge/widgets/awnser/awnser_widget.dart';
import 'package:DevQuiz/core/core.dart';
import 'package:flutter/material.dart';

class QuizWidget extends StatelessWidget {
  final String text;
  const QuizWidget({required this.text});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(children: [
        Text(text, style: AppTextStyles.heading),

        SizedBox(height: 24),
        AwnserWidget(
          title: "Possiblita a criação de aplicativos copilado nativamente"),
        
        AwnserWidget(
          title: "Possiblita a criação de aplicativos copilado nativamente"),
        
        AwnserWidget(
          title: "Possiblita a criação de aplicativos copilado nativamente"),
        
        AwnserWidget(
          title: "Possiblita a criação de aplicativos copilado nativamente"),
      ]),
    );
  }
}
