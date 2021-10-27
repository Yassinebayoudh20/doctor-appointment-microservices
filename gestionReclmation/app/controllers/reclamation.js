const db = require("../models");
const Reclamation = db.Reclamation;
var { typereclamation } = require("../service/typereclamation");
// Create and Save a new Reclamation
exports.create = (req, res) => {
  // Validate request
  if (!req.body.description) {
    res.status(400).send({ message: "Content can not be empty!" });
    return;
  }
  // Create a Reclamation
  let reclamation = new Reclamation({
    patientId: req.body.patientId,
    type: req.body.type,
    contentId: req.params.id,
    description: req.body.description,
    doctorId: req.body.doctorId,
    dateReclamation: Date.now(),
  });

  // Save Reclamation in the database
  reclamation
    .save()
    .then((data) => {
      res.send(data);
    })
    .catch((err) => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while creating the Reclamation.",
      });
    });
};

// Retrieve all Reclamations from the database.
exports.findAll = (req, res) => {
  Reclamation.find()
    .then((data) => {
      res.send(data);
      console.log("ena lkol");
    })
    .catch((err) => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving Reclamations.",
      });
    });
};
const typeReclamation = require("../service/typereclamation");
exports.teste = (req, res) => {
  const id = req.params.id;

  var reclamation;
  Reclamation.find({ contentId: id }).then((data) => {
    reclamation = data;
  });
  typeReclamation(req.params.id)
    .then((data) => {
      if (!data)
        res
          .status(404)
          .send({ message: "Not found Reclamation with id " + idType });
      else return res.send({ infoRreclamation: reclamation, seanceInfo: data });
    })
    .catch((err) => {
      res
        .status(500)
        .send({ message: "Error retrieving Reclamation with id=" + idType });

      console.log("ena shiha");
    });
};
// Retrieve all Reclamations from the database.
exports.findAllByType = (req, res) => {
  const idType = typereclamation;

  Reclamation.find(idType)
    .then((data) => {
      if (!data)
        res
          .status(404)
          .send({ message: "Not found Reclamation with id " + idType });
      else res.send(data);
    })
    .catch((err) => {
      res
        .status(500)
        .send({ message: "Error retrieving Reclamation with id=" + idType });
    });
};

// Find a single Reclamation with an id
exports.findOne = (req, res) => {
  const id = req.params.id;

  Reclamation.findById(id)
    .then((data) => {
      if (!data)
        res
          .status(404)
          .send({ message: "Not found Reclamation with id " + id });
      else res.send(data);
    })
    .catch((err) => {
      res
        .status(500)
        .send({ message: "Error retrieving Reclamation with id=" + id });
    });
};

// Update a Reclamation by the id in the request
exports.update = (req, res) => {
  if (!req.body) {
    return res.status(400).send({
      message: "Data to update can not be empty!",
    });
  }

  const id = req.params.id;

  Reclamation.findByIdAndUpdate(id, req.body, { useFindAndModify: false })
    .then((data) => {
      if (!data) {
        res.status(404).send({
          message: `Cannot update Reclamation with id=${id}. Maybe Reclamation was not found!`,
        });
      } else res.send({ message: "Reclamation was updated successfully." });
    })
    .catch((err) => {
      res.status(500).send({
        message: "Error updating Reclamation with id=" + id,
      });
    });
};

// Delete a Reclamation with the specified id in the request
exports.delete = (req, res) => {
  const id = req.params.id;

  Reclamation.findByIdAndRemove(id, { useFindAndModify: false })
    .then((data) => {
      if (!data) {
        res.status(404).send({
          message: `Cannot delete Reclamation with id=${id}. Maybe Reclamation was not found!`,
        });
      } else {
        res.send({
          message: "Reclamation was deleted successfully!",
        });
      }
    })
    .catch((err) => {
      res.status(500).send({
        message: "Could not delete Reclamation with id=" + id,
      });
    });
};

// Delete all Reclamations from the database.
exports.deleteAll = (req, res) => {
  Reclamation.deleteMany({})
    .then((data) => {
      res.send({
        message: `${data.deletedCount} Reclamations were deleted successfully!`,
      });
    })
    .catch((err) => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while removing all Reclamations.",
      });
    });
};

// Find all published Reclamations
exports.findAllPublished = (req, res) => {
  Reclamation.find({ published: true })
    .then((data) => {
      res.send(data);
    })
    .catch((err) => {
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving Reclamations.",
      });
    });
};
