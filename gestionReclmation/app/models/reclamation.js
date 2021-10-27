module.exports = (mongoose) => {
  var schema = mongoose.Schema(
    {
      patientId: Number,
      type: String,
      contentId: Number,
      description: String,
      doctorId: Number,
      dateReclamation: Date,
    },
    { timestamps: true }
  );

  const Reclamation = mongoose.model("Reclamation", schema);
  return Reclamation;
};
