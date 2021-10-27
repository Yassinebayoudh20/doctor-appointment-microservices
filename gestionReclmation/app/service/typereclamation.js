const https = require("http");
/*const getTypeReclamation = (ordonnanceId) => {
  return new Promise(function (resolve, reject) {
    https
      .get("http://localhost:8088/api/seances/" + ordonnanceId, (resp) => {
        let data = "";
        resp.on("data", (chunk) => {
          data += chunk;
        });
        resp.on("end", () => {
          let url = JSON.parse(data);
          console.log(url);
        });
      })
      .on("error", (err) => {
        reject(err);
      });
  });
};*/
module.exports = function (ordonnanceId) {
  return new Promise(function (resolve, reject) {
    https
      .get("http://localhost:8088/api/seances/" + ordonnanceId, (resp) => {
        let data = "";
        resp.on("data", (chunk) => {
          data += chunk;
        });
        resp.on("end", () => {
          let url = JSON.parse(data);
          console.log(url);
          resolve(url);
        });
      })
      .on("error", (err) => {
        reject(err);
      });
  });
};
