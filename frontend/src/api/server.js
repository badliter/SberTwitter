import { Model, Server } from "miragejs";

const makeServer = ({ environment = "development" } = {}) => (
    new Server({
        environment,

        models: {
            tweet: Model,
        },

        seeds(server) {
            server.create("tweet", {
                userId: "1", tweetId: "1", authorName: "Олег", authorSurname: "Шумейко", content: "test content 1", date: "2020-03-21T20:56:46.856Z",
            });
            server.create("tweet", {
                userId: "1", tweetId: "2", authorName: "Архипов", authorSurname: "Игорь", content: "test content 2", date: "2020-03-21T20:56:46.856Z",
            });
        },

        routes() {
            this.urlPrefix = process.env.API_URL;

            this.get("/getAllTwitts/:id", (schema) => schema.tweets.all());
            this.post("/addsubscription", (schema, request) => {
                const attrs = JSON.parse(request.requestBody);

                return { result: attrs };
            });
        },
    })
);

export default makeServer;
