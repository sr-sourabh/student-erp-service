class EasyHTTP {
    async put(url, data, type, stringify) {
        let request = stringify ? JSON.stringify(data) : data;
        const response = await fetch(url, {
            method: type,
            headers: {
                'Content-type': 'application/json'
            },
            body: request
        });
        return await response.json();
    };

    async post(url, data) {
        const response = await fetch(url, {
            method: "POST",
            body: data
        });
        return await response.json();
    };

    async get(url) {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-type': 'application/json'
            }
        });
        return await response.json();
    }
}